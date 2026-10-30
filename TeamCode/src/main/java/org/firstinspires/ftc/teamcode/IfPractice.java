package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class IfPractice extends OpMode {

    @Override
    public void init() {

    }
    @Override
    public void loop() {
        double leftY = gamepad1.left_stick_y;

        if (leftY > 0.5) {
            telemetry.addData("Left Stick", "Greater than 50% ");
        } else if (leftY > 0) {
            telemetry.addData("Left Stick", "Is greater than 0");
        } else if (leftY < 0) {
            telemetry.addData("Left Stick", "Is Negative");
        } else {
            telemetry.addData("Left Stick", "is Zero");
        }
        telemetry.addData("Left Stick value", leftY);


        double rightY = gamepad1.right_stick_y;

        if (rightY < -0.5) {
            telemetry.addData("Right Stick", "Less than -50% ");
        } else if (rightY < 0) {
            telemetry.addData("Right Stick", "Negative ");
        } else if (rightY > 0.5) {
            telemetry.addData("Right Stick", "Greater than 50% ");
        } else if (rightY > 0) {
            telemetry.addData("Right Stick", "Is greater than 0");
        } else {
            telemetry.addData("Right Stick", "is Zero");
        }
        telemetry.addData("Right Stick Value", rightY);

        telemetry.update();

    }
}
