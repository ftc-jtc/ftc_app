package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Bas Koerts on 30/03/2018.
 */

@TeleOp(name = "Basic: Servo", group = "Servo")
@Disabled
public class TeleOpMode_basic extends LinearOpMode
{
        private Servo servoLift;
        private Servo servoArmLift;

        private static final double ARM_RETRACTED_POSITION = 0.2;
        private static final double ARM_EXTENDED_POSITION = 0.9;


    @Override
    public void runOpMode () throws InterruptedException
    {
        servoLift = hardwareMap.servo.get("servoLift");
        servoArmLift = hardwareMap.servo.get("servoArmLift");

        servoLift.setPosition(ARM_RETRACTED_POSITION);
        servoArmLift.setPosition(ARM_RETRACTED_POSITION);


        waitForStart();

        while (opModeIsActive())
        {
            if(gamepad2.a)
            {
                servoLift.setPosition(ARM_RETRACTED_POSITION);
            }

            if(gamepad2.b)
            {
                servoLift.setPosition(ARM_EXTENDED_POSITION);
            }

            if(gamepad2.x)
            {
                servoArmLift.setPosition(ARM_RETRACTED_POSITION);
            }

            if(gamepad2.a)
            {
                servoArmLift.setPosition(ARM_EXTENDED_POSITION);
            }

            idle();
        }

    }
}