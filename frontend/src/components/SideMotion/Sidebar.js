import * as React from "react";
import { useRef } from "react";
import { motion, sync, useCycle } from "framer-motion";
import { useDimensions } from "./use-dimensions";
import { MenuToggle } from "./MenuToggle";
import { Navigation } from "./Navigation";
import styles from "./SideMotion.module.css";

const sidebar = {
  open: (height = 1000) => ({
    clipPath: `circle(${height * 2 + 200}px at 260px 40px)`,
    transition: {
      type: "spring",
      stiffness: 20,
      restDelta: 2,
    },
  }),
  closed: {
    clipPath: "circle(30px at 559px 40px)",
    transition: {
      delay: 0.5,
      type: "spring",
      stiffness: 400,
      damping: 40,
    },
  },
};

export const Sidebar = ({allNews, setAllNews, clickCoords}) => {
  const [isOpen, toggleOpen] = useCycle(false, true);
  const containerRef = useRef(null);
  //const { height } = useDimensions(containerRef);

  return (
    <motion.nav
      className={styles.nav}
      initial={false}
      animate={isOpen ? "open" : "closed"}
      //custom={height}
      ref={containerRef}
    >
      <motion.div className={styles.background} variants={sidebar}>
          <Navigation allNews={allNews} setAllNews={setAllNews} clickCoords={clickCoords}/>
          <MenuToggle toggle={() => toggleOpen()} />
      </motion.div>
    </motion.nav>
  );
};
