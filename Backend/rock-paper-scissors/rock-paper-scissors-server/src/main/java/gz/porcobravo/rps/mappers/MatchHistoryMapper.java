package gz.porcobravo.rps.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import gz.porcobravo.dtos.MatchHistory;
import gz.porcobravo.rps.data.MatchHistoryData;


@Mapper(componentModel="spring")
public interface MatchHistoryMapper {
	MatchHistoryMapper INSTANCE = Mappers.getMapper(MatchHistoryMapper.class);

	MatchHistory fromEntity(MatchHistoryData entity);
}
