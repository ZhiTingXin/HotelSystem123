package Runner;

import RMI.RemoteHelper;

public class ServerRunner {
	public ServerRunner() {
		new RemoteHelper();
	}
	
	public static void main(String[] args) {
		new ServerRunner();
	}
}
