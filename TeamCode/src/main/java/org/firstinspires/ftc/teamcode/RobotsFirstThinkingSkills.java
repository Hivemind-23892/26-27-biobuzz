package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class RobotsFirstThinkingSkills extends OpMode {
    @Override
    public void init() {

    }


    @Override
    public void loop() {
        boolean aButton = gamepad1.a; // press TRUE, depress FALSE
        // true or false
        if (aButton) {
            telemetry.addData("A Button State", "Pressed!");
        }
        else { //otherwise
            telemetry.addData("A Button","NOT Pressed" );
        }
        telemetry.addData("A Button State", aButton);

    }

    }
