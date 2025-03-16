<table border="3">
  <tr>
    <td>🏗</td>
    <td>Coming soon . . .</td>
  </tr>
</table>

# Demo Multi-Module Project

이 예시는 구조 설명 외 정보량을 최소화합니다. (구현 간소화)

- `api`: 모듈 전이는 점선과 `api` label로 표현
- `implementation`: 실선으로 표현

```mermaid
flowchart TD
    monolithic --> board
    
    subgraph service 
        direction TB

        board -. api .-> board-rdb-adapter -. api .-> board-application
        board -. api .-> board-application
        board -. api .-> board-web-adapter -. api .-> board-application
        
        board-application -. api .-> api

        subgraph api
            direction LR
            board-api -. api .-> board-domain & board-readmodel & board-exception
        end
    end
```