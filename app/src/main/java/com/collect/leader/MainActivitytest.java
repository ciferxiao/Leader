package com.collect.leader;

public class MainActivitytest /*extends AppCompatActivity implements OnChartValueSelectedListener*/ {

/*
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        initPieChart();
    }

    private void initPieChart() {
        binding.included.pieChart.setUsePercentValues(true);
        binding.included.pieChart.getDescription().setEnabled(true);
        binding.included.pieChart.setExtraOffsets(35, 10, 5, 5);

        binding.included.pieChart.setDragDecelerationFrictionCoef(0.95f);

        binding.included.pieChart.setCenterText("Xiao test");

        binding.included.pieChart.setDrawHoleEnabled(true);
        binding.included.pieChart.setHoleColor(Color.TRANSPARENT);

        binding.included.pieChart.setTransparentCircleColor(Color.WHITE);
        binding.included.pieChart.setTransparentCircleAlpha(110);

        binding.included.pieChart.setHoleRadius(58f);
        binding.included.pieChart.setTransparentCircleRadius(61f);

        binding.included.pieChart.setDrawCenterText(true);

        binding.included.pieChart.setRotationAngle(0);
        // enable rotation of the binding.included.pieChart by touch
        binding.included.pieChart.setRotationEnabled(false);
        binding.included.pieChart.setHighlightPerTapEnabled(true);

        // binding.included.pieChart.setUnit(" €");
        // binding.included.pieChart.setDrawUnitsInbinding.included.pieChart(true);

        // add a selection listener
        binding.included.pieChart.setOnChartValueSelectedListener(this);
        binding.included.pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // binding.included.pieChart.spin(2000, 0, 360);

        Legend l = binding.included.pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setTextColor(Color.GREEN);
        l.setXEntrySpace(10f);
        l.setYEntrySpace(5f);
        l.setYOffset(1f);
        l.setXOffset(1f);

        // entry label styling
        binding.included.pieChart.setEntryLabelColor(Color.GREEN);
        binding.included.pieChart.setEntryLabelTextSize(12f);

        setData(4, 1);
    }

    protected final String[] parties = new String[]{
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };

    private void setData(int count, float range) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) ((Math.random() * range) + range / 5),
                    ""*/
/*parties[i % parties.length]*//*
,
                    getResources().getDrawable(R.drawable.star)));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        binding.included.pieChart.setData(data);
        binding.included.pieChart.highlightValues(null);
        binding.included.pieChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
    }

    @Override
    public void onNothingSelected() {
    }
*/
}