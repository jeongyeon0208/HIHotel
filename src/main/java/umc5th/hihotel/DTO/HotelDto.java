package umc5th.hihotel.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter @Setter
@NoArgsConstructor
public class HotelDto {

    @NotNull
    private String hid;
    private String name;
    private String num;
    private String address;

    @Builder
    public HotelDto(String hid, String name, String num, String address) {
        this.hid = hid;
        this.name = name;
        this.num = num;
        this.address = address;
    }
}
