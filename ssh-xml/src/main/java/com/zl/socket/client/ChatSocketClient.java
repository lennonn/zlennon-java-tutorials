package com.zl.socket.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatSocketClient implements Runnable {
	Socket socket = null;
	StringBuffer recevieData;

	public ChatSocketClient() {
		try {
			socket = new Socket("localhost", 8180);
			OutputStream outputStream = socket.getOutputStream();
			OutputStreamWriter opsw = new OutputStreamWriter(outputStream);
			BufferedWriter bw = new BufferedWriter(opsw);

			bw.write("hello world\r\n\r\n");
			bw.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public void run() {
		try {
			BufferedReader serverBufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			// System.out.println("Come from Server:"+
			// serverBufferedReader.readLine());
			recevieData = new StringBuffer(serverBufferedReader.readLine());
			System.out.println("Come from Server:"
					+ serverBufferedReader.readLine());
			while (recevieData.length()!=0) {
				recevieData.append(serverBufferedReader.readLine());
				recevieData = new StringBuffer(serverBufferedReader.readLine());
				System.out.println("Come from Server:"
						+ recevieData);
			}
			socket.close();
			serverBufferedReader.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public static void main(String[] args) {
		ChatSocketClient chatSocketClient = new ChatSocketClient();
		chatSocketClient.run();
	}
}
