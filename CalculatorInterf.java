public interface CalculatorInterf {

    /**
     * этот метод обрабатывает данные, которые задает пользователь, переделывая в читаемый методом calculator текст.
     * @param Expr
     * @return
     */
    String translate(String Expr);

    /**
     * данный метот работает как калькулятор и делает простые математические операции над данными входящими от метода translate
     * @param rpn
     * @return
     */

    double calculator(String rpn);

    /**
     * метод priority расставляет приоритет данных, заданных пользователям
     * @param token
     * @return
     */

    int priority(char token);

    /**
     *
     * @param control
     * @return
     */

    int сheck(String control);
}
