package umc5th.hihotel.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter @Setter
@NoArgsConstructor
public class CustomerDto {

    @NotNull
    private String cid;
    private String name;
    private String phone;

    @Builder
    public CustomerDto(String cid, String name, String phone) {
        this.cid = cid;
        this.name = name;
        this.phone = phone;
    }
}
