package ReceiverDevices;


public class Oven extends Device{

    private enum DeviceStates {
        On,
        Off,
        Running
    }
    private int timer = 0;
    private int temperature = 0;
    private DeviceStates deviceState = DeviceStates.Off;




    private enum OvenProgram {
        ventilated,
        grill,
        defrost
    }

    private enum DeviceCommands {
        SwitchOn,
        SwitchOff,
        SetTimer,
        SetTemperature,
        SetUpProgram,
        StartCooking,
        CheckTimer,
        Interrupt
    }


    public void printDeviceMenu(){
        for (DeviceCommands commands : DeviceCommands.values()) {
            System.out.println(commands);
        }
    }



}
