local id_key = '{id_key_' .. KEYS[1] .. '}'
local key = '{' .. KEYS[2] .. '}'

-- 一次性获取id_key和key的值
local current = tonumber(redis.call('get', id_key) or 0)
local usedStr = redis.call('get', key) or ','

-- 寻找未被占用的雪花值
for value = current + 1, current + 30 do
    if value > 29 then
        value = 1
    end

    if not string.find(usedStr, ',' .. value .. ',', 1, true) then
        current = value
        usedStr = usedStr .. value .. ','
        break
    end
end

-- 更新id_key和key的值
redis.call('set', id_key, current)
redis.call('set', key, usedStr)

return tostring(current)
