import * as React from "react";
import { motion } from "framer-motion";
import { MenuItem } from "./MenuItem.js";
import styles from "./SideMotion.module.css";
import MapSidebar from "./MapSidebar.js";
import { t } from "i18next";

const variants = {
  open: {
    transition: { staggerChildren: 0.07, delayChildren: 0.2 },
    opacity: 1,
  },
  closed: {
    transition: { staggerChildren: 0.05, staggerDirection: -1 },
    opacity: 0,
  },
};

export const Navigation = ({allNews, setAllNews, clickCoords}) => (
  <motion.ul variants={variants} className={styles.ul}>
    <h3 className={styles.h3}>📰 {t("categoryTitle.Title")}</h3>
    <MapSidebar allNews={allNews} setAllNews={setAllNews} clickCoords={clickCoords}/>
  </motion.ul>
);
