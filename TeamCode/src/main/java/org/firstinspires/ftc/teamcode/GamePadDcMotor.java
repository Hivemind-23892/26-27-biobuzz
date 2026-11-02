package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.TestBench1;


    @TeleOp
    public class GamePadDcMotor extends OpMode {
        TestBench1 bench = new TestBench1();

        @Override
        public void init() {
            bench.init(hardwareMap);
        }

        @Override
        public void loop() {
            // If the 'A' button is pressed, run the motor. Otherwise, stop it.
            bench.setMotorSpeed(-gamepad1.left_stick_y);
            bench.setMotorSpeed(-gamepad1.right_stick_y);

            // Optional: show the button state on your driver station
            telemetry.addData("A Button Pressed", gamepad1.a);
        }

    }



