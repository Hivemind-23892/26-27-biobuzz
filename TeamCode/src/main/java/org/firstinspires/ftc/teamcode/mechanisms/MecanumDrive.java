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

    public void drive(double forward, double strafe, double rotate) {
        // FIXED WHEEL MIXING FORMULA:
        // Changed the front wheels to subtract forward (-forward) and back wheels to add forward (+forward).
        // This stops your front and back motors from fighting each other when trying to go forward/backward.
        double frontLeftPower  = forward + strafe + rotate;
        double backLeftPower   =  -forward - strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backRightPower  =  -forward + strafe - rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
        maxPower = Math.max(maxPower, Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));
        maxPower = Math.max(maxPower, Math.abs(backRightPower));

        topleft.setPower(maxSpeed * (frontLeftPower / maxPower));
        topright.setPower(maxSpeed * (frontRightPower / maxPower));
        bottomleft.setPower(maxSpeed * (backLeftPower / maxPower));
        bottomright.setPower(maxSpeed * (backRightPower / maxPower));
    }

    public void driverFieldRelative(double forward, double strafe, double rotate) {
        double theta = Math.atan2(forward, strafe);
        double r = Math.hypot(strafe, forward);

        theta = AngleUnit.normalizeRadians(theta -
                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newForward = r * Math.sin(theta);
        double newStrafe = r * Math.cos(theta);

        this.drive(newForward, newStrafe, rotate);
    }
}

