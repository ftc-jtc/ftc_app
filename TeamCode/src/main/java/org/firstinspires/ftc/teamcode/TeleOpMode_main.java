package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="main: REV", group="all")

public class TeleOpMode_main extends LinearOpMode
{
    private DcMotor LeftDrive;
    private DcMotor RightDrive;
    private DcMotor LiftSysteem;
    private DcMotor LiftSysteem2;
    private DcMotor LiftSysteem3;
    private Servo Klep;

    float fl_power;
    float fr_power;
    float lift_power;
    float lift2_power;
    float lift3_power;


    @Override
    public void runOpMode () throws InterruptedException
    {
        LeftDrive = hardwareMap.dcMotor.get("LeftDrive");
        RightDrive = hardwareMap.dcMotor.get("RightDrive");
        LiftSysteem = hardwareMap.dcMotor.get("LiftSysteem");
        LiftSysteem2 = hardwareMap.dcMotor.get("LiftSysteem2");
        LiftSysteem3 = hardwareMap.dcMotor.get("Liftsysteem3");
        Klep = hardwareMap.servo.get("Klep");

        waitForStart();


        while (opModeIsActive())
        {
            fl_power = gamepad1.left_stick_y + gamepad1.right_trigger - gamepad1.left_trigger - gamepad1.right_stick_y;
            fr_power = -gamepad1.right_stick_y - gamepad1.right_trigger + gamepad1.left_trigger + gamepad1.left_stick_y ;
            lift_power = -gamepad2.right_stick_y ;
            lift2_power = gamepad2.right_stick_x;
            lift3_power = gamepad2.left_stick_y;

            LeftDrive.setPower(fl_power);
            RightDrive.setPower(fr_power);
            LiftSysteem.setPower(Range.clip(lift_power, -0.8, 0.8 ));
            LiftSysteem2.setPower(Range.clip(lift2_power, -0.8, 0.8 ));
            LiftSysteem3.setPower(Range.clip(lift3_power, -0.3, 0.3));

            if (gamepad2.dpad_up) {
                Klep.setPosition(0.5);
            }

            if (gamepad2.dpad_down){
                Klep.setPosition(0);

            }

            if (gamepad2.dpad_left){
                Klep.setPosition(0);
            }

            if (gamepad2.dpad_right){
                Klep.setPosition(0.5);
            }

            telemetry.addLine("left side | ")
                    .addData("trigger", gamepad1.left_trigger)
                    .addData("y", -gamepad1.left_stick_y);
            telemetry.addLine("right side | ")
                    .addData("trigger", gamepad1.right_trigger)
                    .addData("y", gamepad1.right_stick_y);
            telemetry.update();

            idle();
        }

    }
}

