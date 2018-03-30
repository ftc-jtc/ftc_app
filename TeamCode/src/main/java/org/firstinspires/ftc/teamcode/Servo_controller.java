package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Bas Koerts on 30/03/2018.
 */

@TeleOp(name = "Basic: lift", group = "Servo")

public class Servo_controller extends LinearOpMode
{
        private Servo servoLift;
        private Servo servoArmLift;
        private Servo servoArmLift2;
        private CRServo servoMotorLift;

        private static final double LIFT_RETRACTED_POSITION = 0;
        private static final double ARM_LIFT_EXTENDED_POSITION = 0.5;
        private static final double LIFT_EXTENDED_POSITION = 1;


    @Override
    public void runOpMode () throws InterruptedException
    {
        servoLift = hardwareMap.servo.get("servoLift");
        servoArmLift = hardwareMap.servo.get("servoArmLift");
        servoMotorLift = hardwareMap.crservo.get("servoMotorLift");
        servoArmLift2 = hardwareMap.servo.get("servoArmLift2");

        servoArmLift2.setPosition(LIFT_RETRACTED_POSITION);
        servoArmLift.setPosition(LIFT_RETRACTED_POSITION);


        waitForStart();

        while (opModeIsActive()) {
            if (gamepad2.a) {
                servoLift.setPosition(LIFT_RETRACTED_POSITION);
            }

            if (gamepad2.b) {
                servoLift.setPosition(LIFT_EXTENDED_POSITION);
            }

            if (gamepad2.x) {
                servoArmLift.setPosition(LIFT_RETRACTED_POSITION);
                servoArmLift2.setPosition(LIFT_RETRACTED_POSITION);
            }

            if (gamepad2.y) {
                servoArmLift.setPosition(ARM_LIFT_EXTENDED_POSITION);
                servoArmLift2.setPosition(ARM_LIFT_EXTENDED_POSITION);
            }

            if (gamepad2.dpad_up) {
                servoMotorLift.setPower(0.9);
            }

            if (gamepad2.dpad_down) {
                servoMotorLift.setPower(-0.9);
            }

            if (gamepad2.dpad_left){
                servoMotorLift.setPower(0.0);
            }


            idle();
        }

    }
}