package org.firstinspires.ftc.teamcode;

/**
 * Created by standalone on 14-5-2018.
 */



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Autonomous_Yeeeee", group="Auto")

public class Autonomous extends LinearOpMode {

    DcMotor motorFrontLeft = null;
    DcMotor motorRearLeft = null;
    DcMotor motorFrontRight = null;
    DcMotor motorRearRight = null;
    DcMotor motorLift = null;

    Servo servoArmLift = null;
    Servo servoArmLift2 = null;
    CRServo servoMotorLift = null;
    Servo servoArm = null;


    @Override
    public void runOpMode () throws InterruptedException {
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorRearLeft = hardwareMap.dcMotor.get("motorRearLeft");
        motorRearRight = hardwareMap.dcMotor.get("motorRearRight");
        motorLift = hardwareMap.dcMotor.get("motorLift");

        servoArmLift = hardwareMap.servo.get("servoArmLift");
        servoMotorLift = hardwareMap.crservo.get("servoMotorLift");
        servoArmLift2 = hardwareMap.servo.get("servoArmLift2");
        servoArm = hardwareMap.servo.get("servoArm");

        servoArm.setPosition(0.0);

        waitForStart();
        
        DriveForwardTime(-0.5, 1300);
        StopDrivingTime(0, 1000);
        DriveRightTime(-0.5, 400);
        StopDrivingTime(0, 1000);
        TurnRightTime(0.5, 550);
        StopDrivingTime(0, 750 );
        DriveForwardTime(0.3, 700);
        StopDrivingTime(0, 100);


    }


    public void DriveForward(double power) {
        motorFrontLeft.setPower(-power);
        motorRearRight.setPower(power);
        motorRearLeft.setPower(0);
    }

    public void DriveForwardTime(double power, long time) throws InterruptedException {
        DriveForward(power);
        Thread.sleep(time);
    }

    public void DriveRight(double power) {
        motorFrontRight.setPower(-power);
        motorRearLeft.setPower(power);
        motorRearRight.setPower(0);
        motorFrontLeft.setPower(0);
    }

    public void DriveRightTime(double power, long time) throws InterruptedException {
        DriveRight(power);
        Thread.sleep(time);
    }

    public void TurnRight(double power) {
        motorFrontLeft.setPower(-power);
        motorRearLeft.setPower(-power);
        motorRearRight.setPower(0);
        motorFrontRight.setPower(0);

    }

    public void TurnRightTime(double power, long time) throws InterruptedException {
        TurnRight(power);
        Thread.sleep(time);
    }

    public void TurnLeft(double power) {
        motorFrontRight.setPower(power);
        motorRearRight.setPower(power);
        motorRearLeft.setPower(0);
        motorFrontLeft.setPower(0);
    }

    public void TurnLeftTime(double power, long time) throws InterruptedException {
        TurnLeft(power);
        Thread.sleep(time);
    }

    public void StopDriving(double power) {
        motorRearLeft.setPower(power);
        motorRearRight.setPower(power);
        motorFrontLeft.setPower(power);
        motorFrontRight.setPower(power);
    }
    public void StopDrivingTime(double power, long time) throws InterruptedException {
        StopDriving(power);
        Thread.sleep(time);
    }
    public void Arm(double position) {
        servoArm.setPosition(position);
    }

    public void ArmTime(double position, long time) throws InterruptedException {
        Arm(position);
        Thread.sleep(time);
    }

}