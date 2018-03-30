package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Basic: drive-turn", group="Driving")

public class Test_drive extends LinearOpMode {

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
            motorFrontLeft.setPower(gamepad1.right_trigger);
            motorFrontRight.setPower(gamepad1.right_trigger);
            motorRearLeft.setPower(-gamepad1.left_trigger);
            motorRearRight.setPower(-gamepad1.left_trigger);


            idle();
        }

    }
}
