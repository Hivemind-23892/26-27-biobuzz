package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VariablePractice extends OpMode {

    @Override
    public void init () {
       int teamNumber = 23892;
       double motorSpeed = 0.75;
       boolean clawClosed = true;

       telemetry.addData("Team Number", teamNumber);
       telemetry.addData("motor Speed", motorSpeed);
       telemetry.addData( "clawClosed",clawClosed );
    }

    @Override
    public void loop() {

    }
}


