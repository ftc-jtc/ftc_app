package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="main: drive and lift", group="all")

public class TeleOpMode_main extends LinearOpMode
{
    private DcMotor motorFrontLeft;
    private DcMotor motorRearLeft;
    private DcMotor motorFrontRight;
    private DcMotor motorRearRight;

    private Servo servoArmLift;
    private Servo servoArmLift2;
    private CRServo servoMotorLift;

    private static final double LIFT_RETRACTED_POSITION = 0.3;
    private static final double ARM_LIFT_EXTENDED_POSITION = 0.5;
    private static final double LIFT_EXTENDED_POSITION = 0.8;
    private static final double ARM_LIFT_RETRACTED_POSITION = 0.0;

    float fl_power;
    float fr_power;
    float rl_power;
    float rr_power;

    @Override
    public void runOpMode () throws InterruptedException
    {
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorRearLeft = hardwareMap.dcMotor.get("motorRearLeft");
        motorRearRight = hardwareMap.dcMotor.get("motorRearRight");

        servoArmLift = hardwareMap.servo.get("servoArmLift");
        servoMotorLift = hardwareMap.crservo.get("servoMotorLift");
        servoArmLift2 = hardwareMap.servo.get("servoArmLift2");

        servoArmLift2.setPosition(LIFT_RETRACTED_POSITION);
        servoArmLift.setPosition(LIFT_RETRACTED_POSITION);

        waitForStart();

        while (opModeIsActive())
        {
            fl_power = gamepad1.left_stick_y - gamepad1.right_trigger;
            fr_power = -gamepad1.right_stick_y - gamepad1.right_trigger;
            rl_power = gamepad1.right_stick_y + gamepad1.left_trigger;
            rr_power = -gamepad1.left_stick_y + gamepad1.left_trigger;

            motorFrontLeft.setPower(fl_power);
            motorFrontRight.setPower(fr_power);
            motorRearLeft.setPower(rl_power);
            motorRearRight.setPower(rr_power);


            if (gamepad2.x) {
                servoArmLift.setPosition(ARM_LIFT_RETRACTED_POSITION);
            }

            if (gamepad2.y) {
                servoArmLift.setPosition(ARM_LIFT_EXTENDED_POSITION);
            }

            if (gamepad2.left_bumper) {
                servoArmLift2.setPosition(ARM_LIFT_RETRACTED_POSITION);
            }

            if (gamepad2.right_bumper){
                servoArmLift2.setPosition(ARM_LIFT_EXTENDED_POSITION);
            }

            if (gamepad2.dpad_up) {
                servoMotorLift.setPower(-0.9);
            }

            if (gamepad2.dpad_down) {
                servoMotorLift.setPower(0.9);
            }

            if (gamepad2.dpad_left){
                servoMotorLift.setPower(0.0);
            }

            if (gamepad2.dpad_right){
                servoMotorLift.setPower(0.0);
            }

            telemetry.addLine("left side | ")
                    .addData("trigger", gamepad1.left_trigger)
                    .addData("y", gamepad1.left_stick_y);
            telemetry.addLine("right side | ")
                    .addData("trigger", gamepad1.right_trigger)
                    .addData("y", gamepad1.right_stick_y);
            telemetry.addLine("servo's |")
                    .addData("servoArmLift", servoArmLift.getPosition())
                    .addData("servoArmLift2", servoArmLift2.getPosition());
            telemetry.update();

            idle();
        }

    }
}

