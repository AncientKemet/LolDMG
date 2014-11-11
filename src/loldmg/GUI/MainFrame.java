/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.GUI;

import dto.Static.Champion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import loldmg.Code.AADPSGraph;
import loldmg.Code.BonusStats;
import loldmg.Code.HealthGraph;
import loldmg.Code.Interfaces.GraphInterface;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Second;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Robert
 */
public class MainFrame extends javax.swing.JFrame {

    public static MainFrame Instance;
    public JFreeChart chart;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        Instance = this;
        DPSButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GraphPanel.removeAll();
                chart = createChart(createDataset((Champion) championComboBox.getSelectedItem(), (Champion) targetComboBox.getSelectedItem()));
                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setSize(new java.awt.Dimension(700, 450));
                chartPanel.setVisible(true);
                GraphPanel.add(chartPanel);
                GraphPanel.setSize(chartPanel.getSize());
                pack();
            }
        });

    }

    private JFreeChart createChart(final XYDataset dataset) {

        // create the chart...
        final JFreeChart newchart = ChartFactory.createXYLineChart(
                "Auto Attack DPS", // chart title
                "Level", // x axis label
                "Damage", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        newchart.setBackgroundPaint(Color.GRAY);

        // get a reference to the plot for further customisation...
        final XYPlot plot = newchart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.

        return newchart;

    }

    private XYDataset createDataset(Champion dealer, Champion target) {

        final XYSeries series1 = new XYSeries("Damage per second done by auto attacks");
        AADPSGraph aadps = new AADPSGraph();
        BonusStats attackerBonusStats = new BonusStats();
        BonusStats targetBonusStats = new BonusStats();
        for (int i = 1; i < 19; i++) {
            series1.add(i, aadps.GetAADPS(dealer, attackerBonusStats, target, targetBonusStats, i));
        }

        final XYSeries series2 = new XYSeries("Target HP");
        if (ShowTargetHP.isSelected()) {

            new HealthGraph(target, new GraphInterface() {

                @Override
                public void NewData(int x, int value) {
                    series2.add(x, value);
                }
            });
        }

        /*final XYSeries series2 = new XYSeries("Enemy health");
         series2.add(1.0, 440.0);
         series2.add(2.0, 500.0);
         series2.add(3.0, 560.0);
         series2.add(4.0, 720.0);
         series2.add(5.0, 780.0);
         series2.add(6.0, 840.0);
         series2.add(7.0, 900.0);
         series2.add(8.0, 960.0);*/
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        if (ShowTargetHP.isSelected()) {
            dataset.addSeries(series2);
        }

        return dataset;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        championComboBox = new javax.swing.JComboBox();
        targetComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        DPSButton = new javax.swing.JButton();
        ShowTargetHP = new javax.swing.JCheckBox();
        GraphPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setText("Champion");

        championComboBox.setModel(new ChampionBoxModel()
        );
        championComboBox.setRenderer(new ChampionListRenderer());

        targetComboBox.setModel(new ChampionBoxModel()
        );
        targetComboBox.setRenderer(new ChampionListRenderer());

        jLabel2.setText("Target");

        DPSButton.setText("DPS");

        ShowTargetHP.setText("Show Target HP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(championComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(targetComboBox, 0, 773, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ShowTargetHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DPSButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(championComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DPSButton)
                    .addComponent(ShowTargetHP))
                .addContainerGap())
        );

        javax.swing.GroupLayout GraphPanelLayout = new javax.swing.GroupLayout(GraphPanel);
        GraphPanel.setLayout(GraphPanelLayout);
        GraphPanelLayout.setHorizontalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        GraphPanelLayout.setVerticalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DPSButton;
    private javax.swing.JPanel GraphPanel;
    private javax.swing.JCheckBox ShowTargetHP;
    public javax.swing.JComboBox championComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JComboBox targetComboBox;
    // End of variables declaration//GEN-END:variables
}
