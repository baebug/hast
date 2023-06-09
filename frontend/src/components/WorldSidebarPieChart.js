import React, { PureComponent } from "react";
import {
  PieChart,
  Pie,
  Sector,
  Cell,
  ResponsiveContainer,
  LabelList,
} from "recharts";
import language from "../redux/language";

// const data = [
//   { name: "Group A", value: 400 },
//   { name: "Group B", value: 300 },
//   { name: "Group C", value: 300 },
//   { name: "Group D", value: 200 },
// ];

const COLORS = [
  "#ffbb60",
  "#a2de81",
  "#dfa6aa",
  "#94c2e6",
  "#c1a4d6",
  "#b0b0b0",
];

const RADIAN = Math.PI / 180;

export default class PieChartExample extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {
      activeMonth: 0,
    };
  }
  render() {
    const month = this.props.month;
    const isMobile = this.props.isMobile;
    const data = this.props.data.pie;
    const language = this.props.language;
    const month_en = {
      1: "Jan",
      2: "Feb",
      3: "Mar",
      4: "Apr",
      5: "May",
      6: "Jun",
      7: "Jul",
      8: "Aug",
      9: "Sep",
      10: "Oct",
      11: "Nov",
      12: "Dec",
    };

    return (
      <>
        <p
          style={{
            position: "absolute",
            fontSize: isMobile ? "15px" : "20px",
            fontWeight: "600",
            margin: "0 0 10px 20px",
          }}
        >
          {language === "ko" ? `${month}월` : month_en[month]}
        </p>
        <ResponsiveContainer width="100%" height="100%">
          <PieChart width={400} height={300}>
            <Pie
              data={data}
              cx="50%"
              cy="50%"
              labelLine={false}
              outerRadius={80}
              fill="#8884d8"
              dataKey="value"
              stroke="#58636e"
            >
              {data.map((entry, index) => (
                <Cell
                  key={`cell-${index}`}
                  fill={COLORS[index % COLORS.length]}
                />
              ))}

              <LabelList
                dataKey={language === "ko" ? "name_ko" : "name_en"}
                position="outside"
                fill="red"
                offset={9}
              />
            </Pie>
          </PieChart>
        </ResponsiveContainer>
      </>
    );
  }
}
