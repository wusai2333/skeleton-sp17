import java.io.*;
import java.util.*;

public class NBody {
    public static double readRadius(String path) {
        In in = new In(path);
        double radius = 0;
        if(!in.isEmpty()) {
            int num = in.readInt();
            radius = in.readDouble();
        }
        return radius;
    }
    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        List<Planet> planets = new ArrayList<>();
        int num = in.readInt();
        double radius = in.readDouble();
        while (!in.isEmpty()) {
            try {
                double xP = in.readDouble();
                double yP = in.readDouble();
                double xV = in.readDouble();
                double yV = in.readDouble();
                double m = in.readDouble();
                String name = in.readString();
                Planet p = new Planet(xP, yP, xV, yV, m, name);
                planets.add(p);
            }
            catch (InputMismatchException e) {
                break;
            }
        }
        return planets.toArray(new Planet[planets.size()]);
    }
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String name = args[2];
        double radius = NBody.readRadius(name);
        Planet[] p = NBody.readPlanets(name);
        double t = 0;
        double[] xForces = new double[p.length];
        double[] yForces = new double[p.length];
        StdAudio.play("./audio/2001.mid");
        while(t<T){
            for (int i = 0; i < p.length; i++){
                xForces[i] = p[i].calcNetForceExertedByX(p);
                yForces[i] = p[i].calcNetForceExertedByY(p);
                p[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(Planet i : p) {
                i.draw();
            }
            StdDraw.show(10);
            t = t + dt;
            
        }
        System.out.println(p.length);
        System.out.println(String.format("%6.2e",radius));
        for (Planet i: p) {
            System.out.println(String.format("%6.4e %6.4e %6.4e %6.4e %6.4e",
                                             i.xxPos,i.yyPos,i.xxVel,i.yyVel,i.mass)
                                            + " " + i.imgFileName);
        }
        try {
        PrintWriter writer = new PrintWriter("data/new_planets.txt", "UTF-8");
        writer.println(p.length);
        writer.println(String.format("%6.4e",radius));
        for (Planet i: p) {
            writer.println(String.format("%6.4e %6.4e %6.4e %6.4e %6.4e",
                                             i.xxPos,i.yyPos,i.xxVel,i.yyVel,i.mass)
                                            + " " + i.imgFileName);
        }
        writer.close();
        } catch (Exception e) {
            System.out.println("aalsdfasdfa");
        }
    }
}
