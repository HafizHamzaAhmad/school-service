package org.rak.school.unit.feerecord;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "fee_record")
public class FeeRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uuid") private String uuid;
	@Column(name = "student_id") private String studentId;
	@Column(name = "fee_type") private String feeType;
	@Column(name = "fee_month") private String feeMonth;
	@Column(name = "fee_year") private String feeYear;
	@Column(name = "status") private String status;

}
