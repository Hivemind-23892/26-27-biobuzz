package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Mecanum Field Orientate OpMode", group="Mechanisms")
public class MecanumFieldOrientateOpMode extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    double forward, strafe, rotate;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        // ==========================================
        // STANDARD UP / DOWN LOGIC (Both Up or Both Down)
        // ==========================================
        double upGate = Math.floor(Math.max(0.0, gamepad1.right_stick_y)) * Math.floor(Math.max(0.0, -gamepad1.right_stick_y));
        double downGate = Math.floor(Math.max(0.0, -gamepad1.right_stick_y)) * Math.floor(Math.max(0.0, gamepad1.right_stick_y));
        forward = (1.0 * upGate) + (-1.0 * downGate);

        // ==========================================
        // SIDE-TO-SIDE LOGIC (X-Axis)
        // ==========================================
        double leftGate = Math.floor(Math.max(0.0, -gamepad1.right_stick_x)) * Math.floor(Math.max(0.0, -gamepad1.right_stick_x));
        double rightGate = Math.floor(Math.max(0.0, gamepad1.right_stick_x)) * Math.floor(Math.max(0.0, gamepad1.right_stick_x));
        strafe = (-1.0 * leftGate) + (1.0 * rightGate);

        // ==========================================
        // SPECIAL SPIN LOGIC (Right Up + Left Down)
        // ==========================================
        // Right stick up: -1.0 becomes 1.0
        double rightUp = Math.floor(Math.max(0.0, -gamepad1.left_stick_y));
        // Left stick down: 1.0 stays 1.0
        double leftDown = Math.floor(Math.max(0.0, gamepad1.left_stick_y));

        // This value is 1.0 ONLY when right is fully up AND left is fully down
        double customSpinGate = rightUp * leftDown;

        // ==========================================
        // FINAL ROTATION MIXING
        // ==========================================
        // 1.0 * customSpinGate forces a full speed spin when the combo is pressed.
        // Otherwise, it falls back to standard horizontal stick steering when not strafing.
        double standardRotation = (gamepad1.left_stick_x + gamepad1.right_stick_x) * (1.0 - rightGate) * (1.0 - leftGate);

        rotate = (1.0 * customSpinGate) + (standardRotation * (1.0 - customSpinGate));

        drive.driverFieldRelative(forward, strafe, rotate);
    }
}