package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {

    private DcMotor topleft; // linearSlideMotor0
    private DcMotor topright;
    private DcMotor bottomright;
    private DcMotor bottomleft;

    public void init(HardwareMap hwMap) {
        //touch sensor code

        // DC motor
        topleft = hwMap.get(DcMotor.class, "topleft");
        topleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        topright = hwMap.get(DcMotor.class, "topright");
        topright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        bottomleft = hwMap.get(DcMotor.class, "bottomleft");
        bottomleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        bottomright = hwMap.get(DcMotor.class, "bottomright");
       bottomright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setMotorSpeed(double speed)
    {
        // accepts values from  -1.0 = 1.0

        topleft.setPower(speed);
        bottomright.setPower(speed);
        bottomleft.setPower(speed);
        topright.setPower(speed);
        // Optional: explicit directional methods
        ; // linearSlideMotor0



    }

}