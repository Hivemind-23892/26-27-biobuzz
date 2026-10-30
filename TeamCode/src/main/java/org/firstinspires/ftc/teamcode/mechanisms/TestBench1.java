package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench1 {
    private DcMotor motor; // linearSlideMotor0

    public void init(HardwareMap hwMap){
        //touch sensor code

        // DC motor
    motor = hwMap.get(DcMotor.class, "motor");
    motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void setMotorSpeed(double speed) {
        // accepts values from  -1.0 = 1.0

        motor.setPower(speed);


    }
}