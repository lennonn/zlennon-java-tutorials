package com.zl.socket.server;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zl.socket.client.ChatSocketClient;

public class ChatSocketServer {
	/**
	 *
	 */
	private static final long serialVersionUID = 2457172103059943161L;
	private static final Log clientConnectLog = LogFactory
			.getLog(ChatSocketServer.class);
	ServerSocket serverSocket = null;
	StringBuffer recevieData;
	Collection clients = new ArrayList<>();
	TextArea textArea = new TextArea();
	Socket socket = null;

	public ChatSocketServer() {
		try {
			serverSocket = new ServerSocket(8180);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			clientConnectLog.info(e);

			e.printStackTrace();
		}
	}
	public void startServer() throws IOException{
		System.out.println("waiting client to connect");
		socket = serverSocket.accept();
		clients.add(new ChatSocketClient());
		textArea.append("NEW-CLIENT " + socket.getInetAddress() + ":"
				+ socket.getPort());
		textArea.append("\n" + "CLIENTS-COUNT: " + clients.size() + "\n\n");
		System.out.println("client have connected");
		this.sendToClient();
	}
	public String sendData(InputStreamReader inputStreamReader) {
		BufferedReader clientBufferedReader = new BufferedReader(
				inputStreamReader);
		StringBuffer clientData = new StringBuffer();
		try {
			while (clientBufferedReader.readLine() != null) {
				clientData.append(clientBufferedReader.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientData.toString();
	}

	public void dispose() {
		try {
			if (socket != null)
				socket.close();
			clients.remove(this);
			textArea.append("A client out! \n");
			textArea.append("CLIENT-COUNT: " + clients.size() + "\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendToClient() {
		try {

			BufferedReader clientBufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
/*			System.out.println("Come from Client:"
					+ clientBufferedReader.readLine());*/
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream());
			recevieData = new StringBuffer(clientBufferedReader.readLine());
			// boolean flag=true;
			while (recevieData.length() != 0) {
				System.out.println("Come from Client:"
						+ recevieData);
				recevieData.append(clientBufferedReader.readLine());
				dos.writeUTF(this.sendData(new InputStreamReader(System.in)));
				recevieData = new StringBuffer(clientBufferedReader.readLine());
			}
			this.dispose();
			clientBufferedReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ChatSocketServer chatSocketServer = new ChatSocketServer();
		chatSocketServer.startServer();
	}
}
