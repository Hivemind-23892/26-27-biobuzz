package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumDrive {

    private IMU imu;
    private DcMotor topleft; // linearSlideMotor0
    private DcMotor topright;
    private DcMotor bottomright;
    private DcMotor bottomleft;

    public void init(HardwareMap hwMap) {
        // DC motors
        topleft = hwMap.get(DcMotor.class, "topleft");
        topleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        topright = hwMap.get(DcMotor.class, "topright");
        topright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        bottomleft = hwMap.get(DcMotor.class, "bottomleft");
        bottomleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        bottomright = hwMap.get(DcMotor.class, "bottomright");
        bottomright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Standard left side reversal
        topleft.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomleft.setDirection(DcMotorSimple.Direction.REVERSE);

        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);

        imu.initialize(new IMU.Parameters(RevOrientation));


    }


    public void driverFieldRelative(double forward, double strafe, double rotate) {
     double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        double rotX = strafe * Math.cos(-botHeading) - forward * Math.sin((-botHeading));
        double rotY = strafe * Math.sin(-botHeading) + forward * Math.cos((-botHeading));

        rotX = rotX * 1.1;

        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rotate),1 );

        double frontLeftPower = (rotY + rotX + rotate) / denominator;
        double backLeftPower = (rotY - rotX + rotate) / denominator;
        double frontRightPower = (rotY - rotX - rotate) / denominator;
        double bottomRightPower = (rotY + rotX - rotate) / denominator;

           topleft.setPower(frontLeftPower);
            bottomleft.setPower(backLeftPower);
            topright.setPower(frontRightPower);
            bottomleft.setPower(bottomRightPower);





    }
}

