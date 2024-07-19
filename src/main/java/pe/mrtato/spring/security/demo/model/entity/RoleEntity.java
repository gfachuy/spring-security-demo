package pe.mrtato.spring.security.demo.model.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.mrtato.spring.security.demo.model.enums.RoleEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "roles" )
public class RoleEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column( name = "role_name" )
	@Enumerated( EnumType.STRING )
	private RoleEnum roleEnum;

	@ManyToMany( fetch = FetchType.EAGER , cascade = CascadeType.ALL )
	@JoinTable( name ="role_permission" , joinColumns = @JoinColumn(name ="role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id") )
	private Set<PermissionEntity> permissions = new HashSet<>(); 
	
}