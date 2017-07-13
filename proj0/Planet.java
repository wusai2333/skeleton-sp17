// package whatever; // don't place package name!

import java.io.*;
import java.util.*;

public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
        
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet sun) {
        double dx;
        double dy;
        dx = this.xxPos-sun.xxPos;
        dy = this.xxPos-sun.yyPos;
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
        double vx = dt * ax + this.xxVel;
        double vy = dt * ay + this.yyVel;
        this.xxPos = this.xxPos + dt * vx;
        this.yyPos = this.yyPos + dt * vy;
    }
}