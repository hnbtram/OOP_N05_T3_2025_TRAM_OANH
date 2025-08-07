package Utils;  // Hoặc "com.example.quannet.utils" tùy vị trí file

import java.time.Duration;
import java.time.LocalDateTime;
// Đã xóa import DateTimeFormatter vì không sử dụng

public class DateTimeUtils {
    
    /**
     * Tính thời gian sử dụng giữa 2 mốc thời gian
     * @return Định dạng "X giờ Y phút"
     */
    public static String calculateUsageTime(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        return String.format("%d giờ %d phút", hours, minutes);
    }
    
    /**
     * Kiểm tra có phải khung giờ khuyến mãi (22h-8h)
     */
    public static boolean isPromotionTime(LocalDateTime time) {
        int hour = time.getHour();
        return hour >= 22 || hour < 8;
    }
}