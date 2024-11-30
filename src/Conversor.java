public record Conversor(String base_code,
                        String target_code,
                        double conversion_rate,
                        double conversion_result)
{
    public Conversor(String base_code, String target_code, double conversion_rate, double conversion_result) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
    }
}
