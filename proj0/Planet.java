// package whatever; // don't place package name!

import java.io.*;
import java.util.*;

public class Planet {
<<<<<<< HEAD
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
=======
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
>>>>>>> 7696a8c260676538fc7b910e1784dcc336bc0432
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
<<<<<<< HEAD
    }
    public Planet(Planet p) {
=======
        
    }
    public Planet(Planet p){
>>>>>>> 7696a8c260676538fc7b910e1784dcc336bc0432
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
<<<<<<< HEAD
}
=======
    public double calcDistance(Planet sun) {
        double dx;
        double dy;
        dx = this.xxPos-sun.xxPos;
        dy = this.yyPos-sun.yyPos;
        return Math.sqrt(dx*dx + dy*dy);
    }
    public double calcForceExertedBy(Planet sun) {
        double G = 6.67e-11;
        double distance = this.calcDistance(sun);
        double F = G * this.mass * sun.mass / (distance*distance);
        return F;
    }
    public double calcForceExertedByX(Planet sun) {
        double F = this.calcForceExertedBy(sun);
        double distance = this.calcDistance(sun);
        double dx = sun.xxPos - this.xxPos;
        return F*dx/distance;
    }
    public double calcForceExertedByY(Planet sun) {
        double F = this.calcForceExertedBy(sun);
        double distance = this.calcDistance(sun);
        double dy = sun.yyPos - this.yyPos;
        return F*dy/distance;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double F = 0;
        for (Planet p : allPlanets) {
            if (p == this) continue;
            F = F + this.calcForceExertedByX(p);
        }
        return F;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double F = 0;
        for (Planet p : allPlanets) {
            if (p == this) continue;
            F = F + this.calcForceExertedByY(p);
        }
        return F;
    }
    public void update(double dt, double fX, double fY) {
        double ax = fX/this.mass;
        double ay = fY/this.mass;
        this.xxVel = dt * ax + this.xxVel;
        this.yyVel = dt * ay + this.yyVel;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }
    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
>>>>>>> 7696a8c260676538fc7b910e1784dcc336bc0432
