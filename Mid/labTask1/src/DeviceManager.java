import java.util.ArrayList;
import java.util.List;
public class DeviceManager<T extends Device> {

    private final List<T> devices = new ArrayList<>();

    public void addDevice(T device) {
        devices.add(device);
    }

    public void startAllDevices() {
        System.out.println("Starting all devices concurrently...\n");
        for (T device : devices) {
            Thread thread = new Thread(new DeviceRunner(device));
            thread.start();
        }
    }

    // Part 5: Inner and Nested Classes
    public static class DeviceStats {
        public static int totalDevices = 0;
        public static int activeDevices = 0;
    }

    private class DeviceRunner implements Runnable {
        private final T device;

        public DeviceRunner(T device) {
            this.device = device;
            synchronized (DeviceStats.class) {
                DeviceStats.totalDevices++;
                System.out.println(device + "ID"+ device.id+" is added");
            }
        }

        @Override
        public void run() {
            synchronized (DeviceStats.class) {
                DeviceStats.activeDevices++;
            }

            device.showInfo();
            device.start();

            synchronized (DeviceStats.class) {
                DeviceStats.activeDevices--;
            }
        }
    }
}


