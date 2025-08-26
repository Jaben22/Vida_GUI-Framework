package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.service.AppService;
import com.gabriel.drawfx.DrawMode;
import javax.swing.*;
import java.awt.*;


public class DrawingFrame extends JFrame {


    public DrawingFrame(AppService appService){

        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.setLayout(new BorderLayout());
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        JPanel buttonPanel = new JPanel();

        JButton lineButton = new JButton("Line");
        JButton ellipseButton = new JButton("Ellipse");
        JButton rectangleButton = new JButton("Rectangle");

        lineButton.addActionListener(e -> {
            appService.setShapeMode(ShapeMode.Line);
            appService.setDrawMode(DrawMode.Idle);
        });

        ellipseButton.addActionListener(e -> {
            appService.setShapeMode(ShapeMode.Ellipse);
            appService.setDrawMode(DrawMode.Idle);
        });

        rectangleButton.addActionListener(e -> {
            appService.setShapeMode(ShapeMode.Rectangle);
            appService.setDrawMode(DrawMode.Idle);
        });

        buttonPanel.add(lineButton);
        buttonPanel.add(ellipseButton);
        buttonPanel.add(rectangleButton);

        DrawingView drawingView = new DrawingView(appService);
        JScrollPane scrollPane = new JScrollPane(drawingView);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}