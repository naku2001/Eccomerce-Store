package zw.co.afrosoft.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "`file`")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    private Long id;
    @Column
    private String name;
    @Column
    private String extension;
    @Column
    private String location;
    public File(String name, String extension, String location)
    {        this.name = name;
        this.extension = extension;
        this.location = location;
          }
}
