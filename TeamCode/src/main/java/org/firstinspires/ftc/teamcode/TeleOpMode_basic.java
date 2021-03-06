package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Bas Koerts on 03/02/2018.
 */
@TeleOp(name="Basic: drive", group="Driving")

public class TeleOpMode_basic extends LinearOpMode
{
    private DcMotor motorFrontLeft;
    private DcMotor motorRearLeft;
    private DcMotor motorFrontRight;
    private DcMotor motorRearRight;

    @Override
    public void runOpMode () throws InterruptedException
    {
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorRearLeft = hardwareMap.dcMotor.get("motorRearLeft");
        motorRearRight = hardwareMap.dcMotor.get("motorRearRight");

        waitForStart();

        while (opModeIsActive())
        {
            motorFrontLeft.setPower(gamepad1.left_stick_y);
            motorFrontRight.setPower(-gamepad1.right_stick_y);
            motorRearLeft.setPower(gamepad1.right_stick_y);
            motorRearRight.setPower(-gamepad1.left_stick_y);

            idle();
        }

    }
}
