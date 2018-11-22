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

    float fl_power;
    float fr_power;
    float lift_power;
    float lift2_power;


    @Override
    public void runOpMode () throws InterruptedException
    {
        LeftDrive = hardwareMap.dcMotor.get("LeftDrive");
        RightDrive = hardwareMap.dcMotor.get("RightDrive");
        LiftSysteem = hardwareMap.dcMotor.get("LiftSysteem");
        LiftSysteem2 = hardwareMap.dcMotor.get("LiftSysteem2");

        waitForStart();


        while (opModeIsActive())
        {
            fl_power = gamepad1.left_stick_y + gamepad1.right_trigger - gamepad1.left_trigger;
            fr_power = -gamepad1.right_stick_y - gamepad1.right_trigger + gamepad1.left_trigger;
            lift_power = -gamepad2.right_stick_y ;
            lift2_power = gamepad2.right_stick_x;

            LeftDrive.setPower(fl_power);
            RightDrive.setPower(fr_power);
            LiftSysteem.setPower(Range.clip(lift_power, -0.8, 0.8 ));
            LiftSysteem2.setPower(Range.clip(lift2_power, -0.8, 0.8 ));

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

