
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



// 1
enum DeviceType{
    LIGHT("Smart Light",20),
    THERMOSTAT("Smart Light",500),
    CAMERA("Smart Light",100);

    private  String description;
    private int watt;


    DeviceType(String description,int watt){
        this.description = description;
        this.watt = watt;

    }

    public int getWatt(){
        return watt;
    }




}

//part 2

@Retention(RetentionPolicy.RUNTIME)
@interface Manufacturer {
    String name();
    int year() default 2020;
}



//3 abstract class
abstract class Device{
    //fields
    String id;
    DeviceType type;
    public Device(String id, DeviceType type) {
        this.id = id;
        this.type = type;
    }
    //abstract method
    public abstract void start();

    //concrete method
    public void showInfo(){
        System.out.println("Device ID: " + id + ", Type: " + type);
    }
}

// Thermostat
@Manufacturer(name = "Emerson Electric Co.", year = 2021)
class Thermostat extends Device {
    public Thermostat(String id) {
        super(id, DeviceType.THERMOSTAT);
    }

    @Override
    public void start() {
        System.out.println("Thermostat " + id + " is running...");
    }
}
// Light
@Manufacturer(name = "Philips")
class Light extends Device {
    public Light(String id) {
        super(id, DeviceType.LIGHT);
    }

    @Override
    public void start() {
        System.out.println("Light " + id + " is running ...");
    }
}

// Camera
@Manufacturer(name = "Sony")
class Camera extends Device {
    public Camera(String id) {
        super(id, DeviceType.CAMERA);
    }

    @Override
    public void start() {
        System.out.println("Camera " + id + " is  recording...");
    }
}

//part 6

public class Main {
    public static void main(String[] args) {

        DeviceManager<Device> manager = new DeviceManager<>();

        manager.addDevice(new Light("L1"));
        manager.addDevice(new Thermostat("T1"));
        manager.addDevice(new Camera("C1"));

        manager.startAllDevices();
        for (DeviceType device : DeviceType.values()) {
            System.out.println("Device Type:" + device + "  power consumption:" + device.getWatt());
        }


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}

