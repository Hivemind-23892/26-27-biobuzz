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
            if (gamepad1.left_stick_y) {
                bench.setMotorSpeed(0.5);
            } else {
                bench.setMotorSpeed(0.0);
            }

            // Optional: show the button state on your driver station
            telemetry.addData("A Button Pressed", gamepad1.a);
        }
    }



