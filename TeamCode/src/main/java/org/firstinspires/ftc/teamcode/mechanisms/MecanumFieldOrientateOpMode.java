

package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Mecanum Field Orientate OpMode", group = "Mechanisms")
public class MecanumFieldOrientateOpMode extends OpMode {

    MecanumDrive drive = new MecanumDrive();
    double forward, strafe, rotate;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
       if (Math.abs(gamepad1.right_stick_y) > Math.abs(gamepad1.right_stick_x))
       {forward = -gamepad1.right_stick_y;
        strafe = 0;}
       else {
           strafe = gamepad1.right_stick_x;
           forward = 0;
       }



       strafe+=gamepad1.left_stick_x;
       forward+=gamepad1.left_stick_y;

        strafe = Math.min(strafe, 1);

        forward = Math.min(forward, 1);


        // ==========================================
        // SPECIAL SPIN LOGIC / ROTATION
        // =========================================
        double left_trigger = gamepad1.left_trigger;
        double right_trigger = gamepad1.right_trigger;

        // Assign rotation (using left stick X or your custom spin logic)
        rotate = -left_trigger+ right_trigger;


        // ==========================================
        // SEND POWER TO THE DRIVE TRAIN (CRITICAL FIX)
        // ==========================================
        // Replace 'drive.setPower(forward, strafe, rotate)' with whatever
        // method exists in your MecanumDrive class (e.g., drive.drive(forward, strafe, rotate))
        drive.driverFieldRelative (forward, strafe, rotate);
    }

}
