package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    @Test
    @DisplayName("1 + 1 == 2")
    void t1() {
        assertThat(Calc.run("1 + 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("2 + 1 == 3")
    void t2() {
        assertThat(Calc.run("2 + 1")).isEqualTo(3);
    }

    @Test
    @DisplayName("2 + 2 == 4")
    void t3() {
        assertThat(Calc.run("2 + 2")).isEqualTo(4);
    }

    @Test
    @DisplayName("1000 + 280 == 1280")
    void t4() {
        assertThat(Calc.run("1000 + 280")).isEqualTo(1280);
    }

    @Test
    @DisplayName("50 - 30 == 20")
    void t6() {
        assertThat(Calc.run("50 - 30")).isEqualTo(20); // 구현
    }

    @Test
    @DisplayName("150 - 30 == 120")
    void t7() {
        assertThat(Calc.run("50 - 30")).isEqualTo(20); // 구현
    }

    @Test
    @DisplayName("50 - 500 == -450")
    void t5() {
        assertThat(Calc.run("50 - 30")).isEqualTo(20); // 구현
    }

    @Test
    @DisplayName("40 * 3 == 120")
    void t8() {
        assertThat(Calc.run("40 * 3")).isEqualTo(120);

    }

    @Test
    @DisplayName("3 * 12 == 36")
    void t9() {
        assertThat(Calc.run("3 * 12")).isEqualTo(36);
    }

    @Test
    @DisplayName(" 12 / 3 == 4")
    void t10() {
        assertThat(Calc.run("12 / 3")).isEqualTo(4);
    }

    @Test
    @DisplayName("81 / 9 == 9")
    void t11() {
        assertThat(Calc.run("81 / 9")).isEqualTo(9);
    }

    @Test
    @DisplayName("30 - 10 + 20 == 40")
    void t12(){
        assertThat(Calc.run("30 - 10 + 20")).isEqualTo(40);
    }

    @Test
    @DisplayName("30 - 10 + 20 - 60 -120 == -140")
    void t13(){
        assertThat(Calc.run("30 - 10 + 20 - 60 - 120")).isEqualTo(-140);
    }

    @Test
    @DisplayName("10 * 50 == 500")
    void t14(){

        assertThat(Calc.run("10 * 50")).isEqualTo(500);
    }

    @Test
    @DisplayName("10 * -10 == -100")
    void t15() {
        assertThat(Calc.run("10 * -10")).isEqualTo(-100);
    }

    @Test
    @DisplayName("10 * 10 * 10 == 1000")
    void t16() {
        assertThat(Calc.run("10 * 10 * 10")).isEqualTo(1000);
    }
}