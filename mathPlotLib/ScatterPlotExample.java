package mathPlotLib;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class ScatterPlotExample extends JFrame {

    public ScatterPlotExample(double[] xData, double[] yData) {
        initUI(xData, yData);
    }

    private void initUI(double[] xData, double[] yData) {
        XYSeries series = new XYSeries("Data Points");
        for (int i = 0; i < xData.length; i++) {
            series.add(xData[i], yData[i]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createScatterPlot(
                "Scatter Plot Example",
                "X-Axis",
                "Y-Axis",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        double[] xData = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] yData = {2.0, 3.0, 2.5, 5.0, 4.0};

        SwingUtilities.invokeLater(() -> {
            ScatterPlotExample example = new ScatterPlotExample(xData, yData);
            example.pack();
            example.setTitle("Scatter Plot Example");
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
