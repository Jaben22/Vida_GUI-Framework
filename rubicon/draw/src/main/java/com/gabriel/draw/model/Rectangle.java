package com.gabriel.draw.model;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;
import com.gabriel.draw.service.RectangleRendererService;
import lombok.Data;

@Data
public class Rectangle extends Shape{

    public Rectangle(Point start, Point end) {
        super(start);
        this.setEnd(end);
        this.setColor(Color.YELLOW);
        this.setRendererService(new RectangleRendererService());
    }
}
