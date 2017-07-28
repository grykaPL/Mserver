import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import javax.sound.midi.SoundbankResource;
import javax.sound.sampled.Line;
import javax.media.*;
import javax.media.CaptureDeviceInfo;

import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.VideoInputFrameGrabber;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.github.sarxos.webcam.Webcam;

public class gui {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println("ssssssss");
		System.out.println("sdres ip: "+ adres());
		javcv();
	
		try {
			Enumeration<NetworkInterface> enumeration =NetworkInterface.getNetworkInterfaces();
			for(;enumeration.hasMoreElements();)
				{
				NetworkInterface networkInterface = enumeration.nextElement();
				Enumeration<InetAddress> adresses =networkInterface.getInetAddresses();
				for(;adresses.hasMoreElements();){
					InetAddress address =adresses.nextElement();
					System.out.println();
					}
				} 
			}catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String line;
		
	}

final static String adres() throws UnknownHostException{
	return("s");//InetAddress.getLocalHost().getHostAddress());
	}
private Object devices;

private void sluchaj(){
	try {
		ServerSocket serverSocket = new ServerSocket(6001);
		System.out.println("oczekwianie na polaczenie");
		Socket socket =  serverSocket.accept();
		System.out.println("przyjeto polaczenie");
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		out.println("wiadomosc");
		System.out.println("wyslano wiadomosc");
		serverSocket.close();
		
		
		//BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//while ((line = in.readLine())!=null) {
			//System.out.println(line);
			
		//}
	} 
	catch (IOException e) {	
		e.printStackTrace();
		System.out.println(e.getMessage());
	}

	}
	

private static void listaKamer(){
	Vector<Object> lista ;
	String a;
	javax.media.Format format = new javax.media.Format("RGB");
	lista=CaptureDeviceManager.getDeviceList(format);
	System.out.println(lista.size());
	Iterator<Object> iterator =lista.iterator();
	while(iterator.hasNext()){
		CaptureDeviceInfo info = (CaptureDeviceInfo) iterator.next();
		System.out.println(info);
	}
	Webcam webcam = Webcam.getDefault();
	System.out.println(webcam.getName().toString());
	
	
}

private static void javcv(){
	FrameGrabber grabber = new VideoInputFrameGrabber(0);
}
}

