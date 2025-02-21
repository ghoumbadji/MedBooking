package Reporting;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;

public class PieChart {
    private String title;
    private DefaultPieDataset dataset;
    ChartPanel chartPanel;

    public PieChart(String title, DefaultPieDataset dataset)
    {
        this.title = title;
        this.dataset = dataset;
        JFreeChart chart = ChartFactory.createPieChart(
                title,
                dataset,
                true,
                true,
                false
        );
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        plot.setLabelFont(new Font("ubuntu", Font.BOLD, 12));
        chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.WHITE);
    }

    public DefaultPieDataset getDataset()
    {
        return (dataset);
    }

    public void setDataset(DefaultPieDataset dataset)
    {
        this.dataset = dataset;
    }

    public ChartPanel getChartPanel()
    {
        return (chartPanel);
    }
}
