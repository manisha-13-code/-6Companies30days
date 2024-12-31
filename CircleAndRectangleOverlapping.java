class CircleAndRectangleOverlapping {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xedge = (x1 > xCenter) ? x1 : (xCenter > x2) ? x2 : xCenter;
        int yedge = (y1 > yCenter) ? y1 : (yCenter > y2) ? y2 : yCenter;

        int xdist = xCenter - xedge;
        int ydist = yCenter - yedge;

        return xdist * xdist + ydist * ydist <= radius * radius;
    }
}