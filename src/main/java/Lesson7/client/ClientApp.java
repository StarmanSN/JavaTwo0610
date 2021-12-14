package Lesson7.client;

import Lesson7.constants.Constants;
import Lesson7.server.ServerHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientApp extends JFrame {


    private JTextField textField;
    private JTextArea textArea;

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private String login;

    public ClientApp() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prepareUI();
    }

    private void openConnection() throws IOException {
        socket = new Socket(Constants.SERVER_ADRESS, Constants.SERVER_PORT);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(() -> {
            try {
                while (true) {
                    String messageFromServer = dataInputStream.readUTF();
                    if (messageFromServer.equals(Constants.END_COMMAND)) {
                        break;
                    } else if (messageFromServer.startsWith(Constants.AUTH_OK_COMMAND)) {
                        String[] tokens = messageFromServer.split("\\s+");
                        this.login = tokens[1];
                        textArea.append("Успешно авторизован как " + login + "\n");
                    } else if (messageFromServer.startsWith(Constants.CLIENT_LIST_COMMAND)) {
                        // Список клиентов
                    } else {
                        textArea.append(messageFromServer);
                        textArea.append("\n");

                        File history = new File("MessageHistory");
                        if (!history.exists()) {
                            history.mkdirs();
                        }
                        File file = new File(history, "history_" + login + ".txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                            bufferedWriter.append(messageFromServer + "\n");
                        }
                    }
                }
                textArea.append("Соединение разорвано");
                textField.setEnabled(false);
                closeConnection();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        executorService.shutdown();
    }

    private void closeConnection() {
        try {
            dataOutputStream.close();
        } catch (Exception ex) {
        }
        try {
            dataInputStream.close();
        } catch (Exception ex) {
        }
        try {
            socket.close();
        } catch (Exception ex) {
        }
    }

    private void sendMessage() {
        if (textField.getText().trim().isEmpty()) { // trim обрезать пробел спереди и сзади
            return;
        }
        try {
            dataOutputStream.writeUTF(textField.getText());
            textField.setText("");
            textField.grabFocus();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void prepareUI() {
        setBounds(200, 200, 500, 500);
        setTitle("ICQ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        JButton button = new JButton("Отправить");
        panel.add(button, BorderLayout.EAST);
        textField = new JTextField();
        panel.add(textField, BorderLayout.CENTER);

        add(panel, BorderLayout.SOUTH);

        JPanel loginPanel = new JPanel(new BorderLayout());
        JTextField loginField = new JTextField();
        loginPanel.add(loginField, BorderLayout.WEST);
        JTextField passField = new JTextField();
        loginPanel.add(passField, BorderLayout.CENTER);
        JButton authButton = new JButton("Войти");
        loginPanel.add(authButton, BorderLayout.EAST);
        add(loginPanel, BorderLayout.NORTH);

        authButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dataOutputStream.writeUTF(Constants.AUTH_COMMAND + " " + loginField.getText() + " " + passField.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClientApp::new);
    }

}
